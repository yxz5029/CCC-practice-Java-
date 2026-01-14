package graph;

public class NumberOfShipsInARectangle {
    static int countShips(Sea sea, int[] topRight, int[] bottomLeft){
        if(!sea.hasShips(topRight, bottomLeft)){
            return 0;
        }
        if(topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]){
            if(sea.hasShips(topRight, bottomLeft)){
                return 1;
            }
        }
        int hmid = (topRight[0]+bottomLeft[0])/2;
        int vmid = (topRight[1]+bottomLeft[1])/2;
        int lt = countShips(sea,new int[]{hmid,topRight[1]}, new int[]{bottomLeft[0],vmid+1});
        int rt = countShips(sea,topRight, new int[]{hmid+1,vmid+1});
        int lb = countShips(sea,bottomLeft, new int[]{hmid,vmid});
        int rb = countShips(sea,new int[]{topRight[0],vmid}, new int[]{hmid+1,bottomLeft[1]});
        return lt+rt+lb+rb;
    }
}
interface Sea{
    public boolean hasShips(int[] topRight, int[] bottomLeft);
}

