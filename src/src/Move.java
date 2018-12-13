class Move {
	int source;
	int target;
	public Move(int s, int t) {
		source = s; target = t; 
	}
	public String toString() {
		return "(" + source + "," + target + ")";
		}
}  
