public class FloorPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal){
        if (bigCount < 0 || smallCount < 0 || goal < 0){
            return false;
        }
         return ((bigCount >= 0 && smallCount >= 0 && goal > 0) &&
                 (goal <= (5 * bigCount + smallCount)) && (smallCount >= goal % 5));
    }
}
