import java.util.Vector;

public class Permutation {
    Vector<float[]> cbmVector = new Vector<float[]>(1);

    boolean sameContent(float[] arr1, float[] arr2){
        boolean retval = true;
        byte i = 0;
        if(arr1.length != arr2.length){
            retval = false;
        }
        while(retval && i < arr1.length){
            if(arr1[i] != arr2[i]){
                retval = false;
            } else{
                i++;
            }
        }
        return retval;
    }

    boolean VectorContains(float[] arr){
        boolean retval = false;
        byte i;
        i = 0;
        while(!retval && i < cbmVector.size()){
            if(sameContent(arr, cbmVector.get(i))){
                retval = true;
            }
            i++;
        }
        return retval;
    }

    void GeneratePermutation(float[] Val){
        for(byte i = 0; i < 4; i++){
            for(byte j = 0; j < 4; j++){
                if(j!=i){
                    for(byte k = 0; k < 4; k++){
                        if(k!=i && k!=j){
                            for (byte l = 0; l < 4; l++){
                                if(l!=i && l!=j && l!=k){
                                    float[] getter = {Val[i], Val[j], Val[k], Val[l]};
                                    if(!VectorContains(getter)){
                                        cbmVector.add(getter);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
