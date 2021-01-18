package my.chicken.command;

public class CommandFactory {
	private CommandFactory() {}
	
	private static CommandFactory instance = new CommandFactory();
	
	public static CommandFactory getInstance(){
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if (cmd.equals("/admin.chi")) {
			cmdIf = new AdminCommand();
		}else if(cmd.equals("/cateAdd.chi")) {
			cmdIf = new CateAddCommand();
		}else if(cmd.equals("/cateDelete.chi")) {
			cmdIf = new CateDeleteCommand();
		}else if(cmd.equals("/prodAdd.chi")) {
			cmdIf = new ProdAddCommand();
		}else if(cmd.equals("/prodList.chi")) {
			cmdIf = new ProdListCommand();
		}else if(cmd.equals("/prodAddOk.chi")) {
			cmdIf = new ProdAddOkCommand();
		}else if(cmd.equals("/prodDelete.chi")) {
			cmdIf = new ProdDeleteCommand();
		}else if(cmd.equals("/prodEdit.chi")) {
			cmdIf = new ProdEditCommand();
		}else if(cmd.equals("/prodEditOk.chi")) {
			cmdIf = new ProdEditOkCommand();
		}else if(cmd.equals("/eventWrite.chi")) {
			cmdIf = new EventWriteCommand();
		}else if(cmd.equals("/eventEdit.chi")) {
			cmdIf = new EventEditCommand();
		}else if(cmd.equals("/eventList.chi")) {
			cmdIf = new EventListCommand();
		}else if(cmd.equals("/boardList.chi")) {
			cmdIf = new BoardListCommand();
		}else if(cmd.equals("/boardEdit.chi")) {
			cmdIf = new BoardEditCommand();
		}else if(cmd.equals("/boardEditOk.chi")) {
			cmdIf = new BoardEditOkCommand();
		}else if(cmd.equals("/boardWrite.chi")) {
			cmdIf = new BoardWriteCommand();
		}else if(cmd.equals("/boardWriteOk.chi")) {
			cmdIf = new BoardWriteOkCommand();
		}else if(cmd.equals("/boardDelete.chi")) {
			cmdIf = new BoardDeleteCommand();
		}else if(cmd.equals("/boardDeleteOk.chi")) {
			cmdIf = new BoardDeleteOkCommand();
		}else if(cmd.equals("/boardContent.chi")) {
			cmdIf = new BoardContentCommand();
		}
		
		return cmdIf;
	}
}





