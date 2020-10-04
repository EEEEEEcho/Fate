package com.thinkInJava.chapter12;
class NeedsCleanUp{
    private static long counter = 1;
    private final long id = counter++;
    public void dispose(){
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}
class ConstructionException extends Exception{

}
class NeedsCleanup2 extends NeedsCleanUp{
    public NeedsCleanup2() throws ConstructionException{

    }
}

public class CleanupIdiom {
    public static void main(String[] args) {
        NeedsCleanUp nc1 = new NeedsCleanUp();
        try {

        }
        finally {
            nc1.dispose();
        }

        NeedsCleanUp nc2 = new NeedsCleanUp();
        NeedsCleanUp nc3 = new NeedsCleanUp();
        try {

        }
        finally {
            nc3.dispose();
            nc2.dispose();
        }
        try{
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try{
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {

                }
                finally {
                    nc5.dispose();
                }
            }
            catch (ConstructionException e){
                System.out.println(e);
            }
            finally {
                nc4.dispose();
            }
        }
        catch (ConstructionException e){
            System.out.println(e);
        }
    }
}
