import java.io.FileNotFoundException;




public class Solver{
	private Board board;
	private InfoPack info;
	
	public String inFileName;
	public String outFileName;
	
	public Solver(String inFileName, String outFileName) throws ConflictException, FileNotFoundException {
		// TODO Auto-generated constructor stub
		this.inFileName = inFileName;
		this.outFileName = outFileName;
		
		this.info = HandleFile.inputFile(this.inFileName);
		board = new Board(info);
	}

	private synchronized void Solving(Board b) throws ConflictException {
		// TODO Auto-generated method stub
		FillBoard fb = new FillBoard(b.clone());
		b = fb.execute();
		//b.printBoard();
		Guess g = new Guess(b.clone());
		//OK
		b = g.execute();
		System.out.println("Result is:");
		b.printBoard();
		HandleFile.outputFile(b.clone(), this.outFileName);
		//board.printBoard();
	}

	public void run() throws ConflictException {
		// TODO Auto-generated method stub
		try {
			Solving(board.clone());
		} catch (ConflictException e) {
			//e.printMsg();
			//System.out.println("Cannot solve it!");
			throw new ConflictException(e.msg);
		}
		//HandleFile.outputFile(board.clone(), outFileName);
	}
	
	public Board getOriginalBoard() {
		return this.board;
	}
	
}
