class Solution {
    public boolean stoneGame(int[] piles) {

        // int len = piles.length;
        // int alice = 0, bob = 0;
        
        // //From Start
        // for(int i=0;i<len;i++){
        //     if(i%2 == 0){
        //         alice += piles[i];
        //     }else{
        //         bob += piles[i];
        //     }
        // }
        
        // if(alice > bob) return true;

        // alice = 0; bob = 0;

        // //From End
        // if(len % 2 == 0){
        //     for(int j=len-1;j>=0;j--){
        //         if(j%2 != 0){
        //             alice += piles[j];  
        //         }else{
        //             bob += piles[j];
        //         }
        //     }
        // }else{
        //     for(int j=len-1;j>=0;j--){
        //         if(j%2 == 0){
        //             alice += piles[j];
        //         }else{
        //             bob += piles[j];
        //         }
        //     }
        // }

        // if(alice > bob) return true;
        // return false;
        return true;
    }
}