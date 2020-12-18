public class javase {
public static boolean isSorted(int[] array){
      if(array==null||array.length==0){
          return false;
      }


     /* if(array.length==0||array==null){

      }*/
    for(int i=0;i<array.length-1;i++){
        if(array[i]>array[i+1]){
            return false;
        }
    }
    return true;
}

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7};
        System.out.println(isSorted(array));
    }
}
