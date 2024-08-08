package ex17_12_notifyall_wait;

class SharedArea {

	private double result;

	SharedArea() {
	}

	public double getResult() {
		return this.result;
	}

	public void setResult(double d) {
		this.result = d;
	}
	
	private boolean isReady; // 디폴트 false
	
	public boolean isReady() {
		return this.isReady;
	}
	
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

}
