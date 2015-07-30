package com.zhidian.server.model.input;

public class CheckUserIsExist extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9197227328114191227L;

	public Input Input;
	
	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input{
		
		public int Type;
		public String  TypeEx;
		public int getType() {
			return Type;
		}
		public void setType(int type) {
			Type = type;
		}
		public String getTypeEx() {
			return TypeEx;
		}
		public void setTypeEx(String typeEx) {
			TypeEx = typeEx;
		}
		
		
		
	}
}
