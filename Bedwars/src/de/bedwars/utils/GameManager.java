package de.bedwars.utils;



public enum GameManager {

	
	LOBBY(),GAME(),Restart();
	

	
	private static GameManager currentstate;
	
	
	
	public static void setState(GameManager state){
		
		GameManager.currentstate = state;
		
	}
	
	public static boolean isState(GameManager state){
		
		return GameManager.currentstate == state;
	}
	
	
	public static GameManager getState(){
		
		
		return currentstate;
	}
	
	public static String getStatus(){
		String s = "";
		
		if(isState(GameManager.LOBBY)){
			s = "§7»§aLobby§7«";

		}else if(isState(GameManager.GAME)){

			s = "§7»§4Ingame§7«";
					
		}else if(isState(GameManager.Restart)){

			s = "§7»§bRestart§7«";
					
		}
		return s;
		
		
	}
	
}





