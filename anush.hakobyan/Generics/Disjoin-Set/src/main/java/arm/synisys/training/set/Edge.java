package arm.synisys.training.set;

public class Edge<R> {
	    private R member1;
	    private R member2;
	    
	    public Edge(R member1, R member2){
	        this.member1 = member1;
	        this.member2 = member2;
	    }
	    
	    public R getMem1() { 
	    	return this.member1; 
	    }
	    public R getMem2() { 
	    	return this.member2; 
	    }
}
