import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException, IOException {

		Peticion pet = new Peticion();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Elija una opción: ");
		System.out.println("1: Crear");
		System.out.println("2: Leer todos");
		System.out.println("3: Leer uno");
		System.out.println("4: Modificar");
		System.out.println("5: Borrar");
		String choice = scanner.nextLine();

		switch (choice) {
		case "1":
			System.out.print("Nombre de la entrada a crear:");
			String nombreCrear = scanner.nextLine();
			System.out.print("Tipo de la entrada a crear:");
			String tipoCrear = scanner.nextLine();
			System.out.print("Gen de la entrada a crear:");
			Integer genCrear = Integer.parseInt(scanner.nextLine());
			pet.create(nombreCrear, tipoCrear, genCrear);
			break;
		case "2":
			pet.readAll();
			break;
		case "3":
			System.out.print("Id de la entrada a leer:");
			Integer idLeer = Integer.parseInt(scanner.nextLine());
			pet.readOne(idLeer);
			break;
		case "4":
			System.out.print("Id de la entrada a modificar:");
			Integer idModificar = Integer.parseInt(scanner.nextLine());
			System.out.print("Nombre de la entrada a modificar:");
			String nombreModificar = scanner.nextLine();
			System.out.print("Tipo de la entrada a modificar:");
			String tipoModificar = scanner.nextLine();
			System.out.print("Gen de la entrada a modificar:");
			Integer genModificar = Integer.parseInt(scanner.nextLine());
			pet.update(idModificar, nombreModificar, tipoModificar, genModificar);
			break;
		case "5":
			System.out.print("Id de la entrada a borrar:");
			Integer idBorrar = Integer.parseInt(scanner.nextLine());
			pet.delete(idBorrar);
			break;
		}

	}
}