package com.scenario.projeto2;

public class luminaria {
	private boolean status=false;
	
	// fun Sensor Movimento
	//fun Interruptor
	
	public boolean Luminaria() {
		return status;
		
	}
	public boolean SensorMovimento(boolean status) {
		boolean movimento= false;
		if(movimento == true) {
			status = true;
		}else {
			status = false;
		}
		return status;
	}
	
	public boolean Interruptor(boolean status) {
		boolean interrup = false;
		
		if(interrup == true) {
			status = true;
		}else {
			status = false;
		}
		return status;
	}

}
