/**
 * // This is the Robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * class Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     function move() {}
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     function turnLeft() {}
 *     function turnRight() {}
 *
 *     // Clean the current cell.
 *     function clean() {}
 * }
 */

class Solution {
    
    private $room = [];    
    private $rotation = 0;
    private $stack;
    private $robot;
    
    /**
     * @param Robot $robot
     * @return 
     */
    function cleanRoom($robot) {
        $x = 0;
        $y = 0;
        $this->stack = new SplStack();
        $this->stack->push([$x,$y]);
        $this->robot = $robot;
        $this->dfs($x,$y);
    }
    
    function dfs($x, $y){
        
        if(!isset($this->room[$x][$y])){
            $this->robot->clean();
            $this->room[$x][$y] = 1;
        }
        
        foreach([
            90,
            270,
            0,
            180,
        ] as $turnBearing){
            
            //convert bearing to offset
            switch($turnBearing){
                case 90:
                    $turn = [1,0];
                    break;
                case 270:
                    $turn = [-1,0];
                    break;
                case 180:
                    $turn = [0,-1];
                    break;
                case 0:
                    $turn = [0,1];
                    break;
            }
            
            list($xOffset, $yOffset) = $turn;
            
            $newX = $x + $xOffset;
            $newY = $y + $yOffset;

            //skip obstacles
            if(isset($this->room[$newX][$newY]) && $this->room[$newX][$newY] === 0)
                continue;
            
            //skip cleaned rooms
            if(isset($this->room[$newX][$newY]) && $this->room[$newX][$newY] === 1)
                continue;
            
            $this->rotateToBearing($turnBearing);
            
            if($this->robot->move()){
                //save breadcrumbs to be able to return
                $this->stack->push([$x, $y]);
                $this->dfs($newX, $newY);
            }
            else {
                //remember obstacles
                $this->room[$newX][$newY] = 0;
            }
        }
        
        //return to prev position;
        $pos = $this->stack->pop();
        $this->returnToPos($x, $y, $pos[0], $pos[1]);
    }
    
    private function rotateToBearing($turnBearing){
        $rightRotations = $turnBearing >= $this->rotation ? ($turnBearing - $this->rotation) / 90 : (360 - ($this->rotation - $turnBearing)) / 90;
        $leftRotations = $turnBearing <= $this->rotation ? ($this->rotation - $turnBearing) / 90 : (360 - ($turnBearing - $this->rotation)) / 90;

        if($leftRotations <= $rightRotations) 
            while($leftRotations > 0){
                $leftRotations--;
                $this->rotation -= 90;
                if($this->rotation < 0)
                    $this->rotation = $this->rotation + 360;
                $this->robot->turnLeft();
            }
        else {
            while($rightRotations > 0){
                $rightRotations--;
                $this->rotation += 90;
                if($this->rotation >= 360)
                    $this->rotation = $this->rotation - 360;
                $this->robot->turnRight();
            }
        }
    }
    
    private function returnToPos($curX,$curY,$x,$y){
        if($x > $curX)
            $turnBearing = 90;
        elseif($x < $curX)
            $turnBearing = 270;
        elseif($y > $curY)
            $turnBearing = 0;
        elseif($y < $curY)
            $turnBearing = 180;
        $this->rotateToBearing($turnBearing);
        $this->robot->move();
    }
    
}