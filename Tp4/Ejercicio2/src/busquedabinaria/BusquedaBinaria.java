package busquedabinaria;

public class BusquedaBinaria {
	
	//Constructor
	public BusquedaBinaria() {
		super();
	}

	//Metodo binarySearch
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

	//Metodo Interativo
	public static boolean Interativo(int[] array, int n) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == n) {
				return true;
			}
		}
		return false;
	}
}
