package application.model;

public class ClassPB {
	
	//
	private ProcessBuilder pb01 = new ProcessBuilder();
	private ProcessBuilder pb02 = new ProcessBuilder();
	
	// constructeur(s)
	public ClassPB(ProcessBuilder p_pb01, ProcessBuilder p_pb02) {
		this.pb01 = p_pb01;
		this.pb02 = p_pb02;
	}
	
	// getter(s)
	public ProcessBuilder getPB01() {
		return this.pb01;
	}
	
	public ProcessBuilder getPB02() {
		return this.pb02;
	}
	
}
