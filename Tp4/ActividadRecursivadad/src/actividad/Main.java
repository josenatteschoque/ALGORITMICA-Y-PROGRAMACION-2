package actividad;

public class Main {
	public static void main(String[] args) {
		
		int array[] = {1,2,3,4,5,6,7,8};
		long inicio = 0;
		
		//System.out.println(binarySearch(array, 6, 0, 7));
		System.out.println(Iterativa(array, 6));
		
		long fin = System.currentTimeMillis();
		long TiempoEjecucion = fin - inicio;
		System.out.println("Tiempo:" + TiempoEjecucion +" ms");
		
	}
	
	
	public static boolean binarySearch(int []data, int target, int low, int high) {
		if(low > high) {
			return false;
		}
		else {
			int mid = (low + high)/2;
			
			if(target ==  data[mid]) {
				return true;
			}else if(target < data[mid]) {
				return binarySearch(data, target, low, mid - 1);
			}else {
				return binarySearch(data, target, mid + 1, high);
			}
		}
	}
	
	public static boolean Iterativa(int array[], int n) {
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == n) {
				return true;
			}
		}
		return false;
	}
}
