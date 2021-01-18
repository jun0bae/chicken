package my.display.command;

public class CommandFactory {
	private CommandFactory() {}
	
	private static CommandFactory instance = new CommandFactory();
	
	public static CommandFactory getInstance(){
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if(cmd.equals("/boardList.dis")) {
		cmdIf = new BoardListCommand();
		}else if(cmd.equals("/boardDelete.dis")) {
			cmdIf = new BoardDeleteCommand();
		}else if(cmd.equals("/boardDeleteOk.dis")) {
			cmdIf = new BoardDeleteOkCommand();
		}else if(cmd.equals("/boardContent.dis")) {
			cmdIf = new BoardContentCommand();
		}else if(cmd.equals("/boardWrite.dis")) {
			cmdIf = new BoardWriteCommand();
		}else if(cmd.equals("/boardWriteOk.dis")) {
			cmdIf = new BoardWriteOkCommand();
		}else if(cmd.equals("/boardEdit.dis")) {
			cmdIf = new BoardEditCommand();
		}else if(cmd.equals("/boardEditOk.dis")) {
			cmdIf = new BoardEditOkCommand();
		}else if(cmd.equals("/prodList.dis")) {
			cmdIf = new ProdListCommand();
		}else if(cmd.equals("/eventList.dis")) {
			cmdIf = new EventListCommand();
		}else if(cmd.equals("/prodView.dis")) {
			cmdIf = new ProdViewCommand();
		}
		
		return cmdIf;
	}
}





