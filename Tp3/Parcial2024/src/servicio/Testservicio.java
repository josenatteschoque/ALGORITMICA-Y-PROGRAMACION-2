/*a) Cargar los siguientes planes:

•	Básico, 25 mbits fibra óptica, $ 18.500
•	Básico, 50 mbits fibra óptica, $ 21.700
•	Premium, 50 mbits fibra óptica, $ 37.100
•	Premium, 100 mbits fibra óptica, $ 54.500
*/
package servicio;

public class Testservicio {
	public static void main(String[] args) {
		TipoServicio a = new TipoServicio(1, "basico");
		TipoServicio b = new TipoServicio(2, "premium");
		
		Servicio a1 = new Servicio(1, "25 mbits fibra óptica");
		Servicio a2 = new Servicio(1, "50 mbits fibra óptica");
		Servicio a3 = new Servicio(2, "100 mbits fibra óptica");
		
		Plan p1 = new Plan(a, a1, 18500);
		Plan p2 = new Plan(a, a2, 21700);
		Plan p3 = new Plan(b, a2, 37100);
		Plan p4 = new Plan(b, a3, 54500);
		
		Empresa e1 = new Empresa(1, "pujol", p1, "jose", true);
		Persona persona1 = new Persona(123, "calle e","leo", p4);
		
		Cliente []cliente = new Cliente[2];
		cliente[0] = e1;
		cliente[1] = persona1;
		
		for(int i =0; i < cliente.length; i++) {
			System.out.println(cliente[i]);
		}
	

	}
}
