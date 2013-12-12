import java.io.FileNotFoundException;




public class Main {
	/**
	 * @param args
	 */	
	
	private static final String inFileName = "input.txt";
	private static final String outFileName = "output.txt";
	
	public static void main(String[] args) {
		String in = inFileName;
		String out = outFileName;
		
		try{
			if(args.length == 0)
				;
			else if(args.length == 1)
				in = args[0];
			else if(args.length == 2) {
				in = args[0];
				out = args[1];
			}
			else throw new ConflictException("Invalid Arguments");
		
			Solver solver = new Solver(in, out);
			solver.run();
		}
		catch(ConflictException ex) {
			ex.printMsg();
			System.out.println("Cannot solve it");
			
			//###########################
			// this line is important as it will create a output file including sentence "UNSOLVABLE"
			HandleFile.CreateErrorFile(out);
			//###########################
		}
		catch(FileNotFoundException ex) {
			System.out.println("FileNotFound");
			System.out.println("Cannot solve it");
		}
		finally{
			System.exit(0);
		}
		
	}

}
