public class PaintJob {

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBucket){
        double finalNumber = 0;
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBucket < 0){
            return -1;
        }else {
            double area = area(width, height);
            double areaNumber = area / areaPerBucket;
            finalNumber = Math.round((double)areaNumber - extraBucket);
        }
        return (int)finalNumber;
    }

    public static double area(double x, double y){
        if (x <= 0 || y <= 0){
            return -1;
        }
         double area = x * y;
         return area;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket){
        double bucketCount = 0;
        if (width <= 0 || height <= 0 || areaPerBucket <= 0){
            return -1;
        }else {
            double area = area(width, height);
            bucketCount = Math.round((double)area/areaPerBucket);
        }
        return (int)bucketCount;
    }

}
