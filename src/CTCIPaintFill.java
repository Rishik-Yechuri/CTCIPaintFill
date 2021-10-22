import java.util.Arrays;

public class CTCIPaintFill {
    public static void main(String[] args){
        try {
            CTCIPaintFill obj = new CTCIPaintFill();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run(String[] args) {
        //Creates a picture represented by numbers
        int[][] pictureToPass = {{0,0,0,0,1},{1,1,1,0,0},{1,2,1,0,2},{0,2,1,1,2},{0,0,0,2,1}};
        //Saves the result of calling the paint function on the picture
        int[][] modifiedPicture = fillSpotWithPaint(pictureToPass,3,3,5);
        //Prints out the new picture
        for(int y=0;y<modifiedPicture[0].length;y++){
            System.out.println(Arrays.toString(modifiedPicture[y]));
        }
    }
    //Calls recursivePaintFill and passes in starting color
    public int[][] fillSpotWithPaint(int[][] originalPicture,int y,int x,int newColor){
        return recursivePaintFill(originalPicture,y,x,newColor,originalPicture[y][x]);
    }
    //Recursively paints the picture
    public int[][] recursivePaintFill(int[][] picture,int currY,int currX,int newColor,int originalColor){
        if(picture[currY][currX] == originalColor){
            picture[currY][currX] = newColor;
            if(currY-1 >= 0){
                picture = recursivePaintFill(picture,currY-1,currX,newColor,originalColor);
            }
            if(currY+1 < picture.length){
                picture = recursivePaintFill(picture,currY+1,currX,newColor,originalColor);
            }
            if(currX-1 >= 0){
                picture = recursivePaintFill(picture,currY,currX-1,newColor,originalColor);
            }
            if(currY+1 < picture[0].length){
                picture =  recursivePaintFill(picture,currY,currX+1,newColor,originalColor);
            }
            return picture;
        }
        return picture;
    }
}