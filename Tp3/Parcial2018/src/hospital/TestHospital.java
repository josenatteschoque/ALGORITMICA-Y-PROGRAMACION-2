/*2) Realizar un programa de prueba que crea instancias de médicos, enfermeros, pacientes y turnos. 
 * Crear un array con todo el personal del hospital y calcular el sueldo para cada uno de ellos. 
 * Crear un array con los turnos de los pacientes y mostrar todos los pacientes para un médico determinado.*/
package hospital;

public class TestHospital {
	public static void main(String[] args) {
		
		//Creo el personal
		Enfermero e1 = new Enfermero(1234, "jose", 5);
		Enfermero e2 = new Enfermero(1209, "ana", 1);
		
		Medico m1 = new Medico(142, "lujan", 8);
		Medico m2 = new Medico(165, "pedro", 2);

		//Creo los pacientes y turnos
		Paciente p1 = new Paciente("monica", "12345678");
		Paciente p2 = new Paciente("lucia", "87654321");
		
		Turno t1 = new Turno("12/5", "18:00");
		Turno t2 = new Turno("13/5", "18:30");
		
		//Arreglo polimorfico del personal
		Personal[] personal = {m1, m2, e1, e2};		
		
		for(int i = 0; i < personal.length; i++) {
		
			System.out.println("Nombre:"+personal[i].getNombre()+" Sueldo:$"+personal[i].CalcularSueldo());
		
		}
		
		Turno[] turno = {t1, t2};

		t1.setPaciente(p1);
		t1.setMedico(m1);	//M1 atiende a t1
		
		t2.setPaciente(p2);
		t2.setMedico(m2);	//M2 atiende a t2
		
		System.out.println("Pacientes del medico "+m1.getNombre().toUpperCase());
		
		for(int j = 0; j < turno.length; j++) {
			if(turno[j].getMedico() != null && turno[j].getMedico().equals(m1)) {
				System.out.println("Turno: "+turno[j].getPaciente().getNombre()+" Fecha: "+turno[j].getFecha()+" Hora: "+turno[j].getHora());
			}
		
		}
	}
}
