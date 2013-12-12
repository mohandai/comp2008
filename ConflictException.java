


public class ConflictException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg = "no comment";
	public ConflictException(String msg) {
		//System.out.println(msg);
		//System.out.println("Can't Solve It");
		this.msg = msg;
	}
	public ConflictException() {
		//System.out.println("Can't Solve It");
			
	}
	public void printMsg() {
		System.out.println(msg);
	}
}
