package com.uisrael.cursos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.cursos.modelo.Contenidos;
import com.uisrael.cursos.modelo.Curso;
import com.uisrael.cursos.modelo.CursoHasContenidos;
import com.uisrael.cursos.modelo.Estudiante;
import com.uisrael.cursos.modelo.Horario;
import com.uisrael.cursos.modelo.Inscripcion;
import com.uisrael.cursos.modelo.Tutor;
import com.uisrael.cursos.servicios.IContenidoServicio;
import com.uisrael.cursos.servicios.ICursoHasContenidoServicio;
import com.uisrael.cursos.servicios.ICursoServicio;
import com.uisrael.cursos.servicios.IEstudianteServicio;
import com.uisrael.cursos.servicios.IInscripcionesServicio;
import com.uisrael.cursos.servicios.ITutorServicio;

import jakarta.persistence.Entity;

@SpringBootTest
class CursosApplicationTests {
	@Autowired
	ICursoServicio servicioCurso;
	@Autowired

	IInscripcionesServicio servicioInscripcion;
	@Autowired

	IEstudianteServicio servicioEstudiante;
	@Autowired

	IContenidoServicio servicioContenido;
	@Autowired

	ITutorServicio tutorContenido;
	@Autowired

	ICursoHasContenidoServicio curconContenido;
	
	@Test
	void contextLoads() throws ParseException {
		
		Curso nuevo =new Curso();
		nuevo.setNombre("Prueba 1");
		nuevo.setCosto(50);
		nuevo.setEstado(true);
		nuevo.setFechaRegistro(new Date());
		nuevo.setDescripcion("prueba OJO");
		servicioCurso.insertarCurso(nuevo);
		List<Curso> cursoTodosa =  servicioCurso.traerTodosMisCursos("Prueba 1");
		for (Curso curso : cursoTodosa) {
			System.out.print(curso.getNombre());

		}

		//Type Query Ejemplo 1 typeQUery
		
		List<Curso> cursoTodos = servicioCurso.listarCursoTQ();
		System.out.print(cursoTodos);
		//Type Query Ejemplo 2 typeQUery parametro
		
		List<Curso> cursoParametro = servicioCurso.listarCursoParametro("Prueba 1");
		System.out.print(cursoParametro);

		//Create
		Estudiante estNuevo = new Estudiante();
		estNuevo.setApellidoEstudiante("Abarca");
		estNuevo.setNombreEstudiante("Jesus");
		estNuevo.setCedulaEstudiante("1725329005");
		servicioEstudiante.insertarEstudiante(estNuevo);
		
		// Ejercicio TypeQuery Ejemplo 3 typeQUery parametro
		List<Estudiante> estudianteParametro =  servicioEstudiante.buscarEstudiantesPorNombreYApellido("Jesus","Abarca");
		System.out.println(estudianteParametro);
		// Ejercicio TypeQuery Ejemplo 4 typeQUery parametro
		List<Estudiante> buscarEstudiantesPorCedulaIniciandoCon =  servicioEstudiante.buscarEstudiantesPorCedulaIniciandoCon("1725329005");
		System.out.println(buscarEstudiantesPorCedulaIniciandoCon);
		// Ejercicio TypeQuery Ejemplo 5 typeQUery parametro
		List<Estudiante> buscarEstudiantesPorNombreOApellidoConteniendo =  servicioEstudiante.buscarEstudiantesPorNombreOApellidoConteniendo("Abarca");
		System.out.println(buscarEstudiantesPorNombreOApellidoConteniendo);
		
        
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setCurso( nuevo);
		inscripcion.setFechaInscripcion(new Date());
		inscripcion.setFkEstudiante(estNuevo);
		inscripcion.setEstadoInscripcion(true);
		servicioInscripcion.insertarInscripcion(inscripcion);
		// Ejercicio TypeQuery Ejemplo 6 typeQUery parametro
		List<Inscripcion> buscarInscripcionesPorCursoYEstado =  servicioInscripcion.buscarInscripcionesPorCursoYEstado(nuevo,true);
		System.out.println(buscarInscripcionesPorCursoYEstado);
		// Ejercicio TypeQuery Ejemplo 7 typeQUery parametro
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse("2023-01-01");
        Date endDate = dateFormat.parse("2024-12-31");
		List<Inscripcion> buscarInscripcionesPorFechaEntre =  servicioInscripcion.buscarInscripcionesPorFechaEntre(startDate, endDate);
		System.out.println(buscarInscripcionesPorFechaEntre);
		// Ejercicio TypeQuery Ejemplo 8 typeQUery parametro
		
		List<Inscripcion> buscarInscripcionesPorEstudianteOrdenadasPorFechaDesc =  servicioInscripcion.buscarInscripcionesPorEstudianteOrdenadasPorFechaDesc(estNuevo);
		System.out.println(buscarInscripcionesPorEstudianteOrdenadasPorFechaDesc);
		//Leer
		Estudiante estudiantePorId = servicioEstudiante.obtenerEstudiantePorId(estNuevo.getIdEstudiante());
		Integer idEstudiante = estudiantePorId.getIdEstudiante();
		
		
		//Actualizar 
		estudiantePorId.setNombreEstudiante("Antonio");
		servicioEstudiante.actualizarEstudiante(estudiantePorId);
		
		// Delete
		// servicioEstudiante.eliminarEstudiante(estudiantePorId);
		
		
        System.out.print(idEstudiante );
        
        Contenidos nContenido =new Contenidos();
		nContenido.setDescripcionContenido("Algebra");
		nContenido.setTipoContenido("Lineal");
		nContenido.setTituloContenido("Algebra 1");
		servicioContenido.insertarContenidos(nContenido);
		// Ejercicio TypeQuery Ejemplo 9 typeQUery parametro
		List<Contenidos> buscarContenidosPorTitulo = servicioContenido.buscarContenidosPorTitulo("Algebra 1");
		// Ejercicio TypeQuery Ejemplo 10 typeQUery parametro

	    List<Contenidos> buscarContenidosPorDescripcionContiene = servicioContenido.buscarContenidosPorDescripcionContiene("Algebra");
		// Ejercicio TypeQuery Ejemplo 11 typeQUery parametro

	    List<Contenidos> buscarContenidosPorTipo = servicioContenido.buscarContenidosPorTipo("Lineal");
		System.out.println(buscarContenidosPorTitulo);
		System.out.println(buscarContenidosPorDescripcionContiene);
		System.out.println(buscarContenidosPorTipo);
		
		Tutor nTutor =new Tutor();
		nTutor.setApellido("Ramos");
		nTutor.setCorreo("antonxabarca@gmail.com");
		nTutor.setNombre("Erika");
		nTutor.setTelefono("0969046751");
		
		tutorContenido.insertarTutor(nTutor);
		// Ejercicio TypeQuery Ejemplo 12 nativeQuery parametro

		List<Tutor> buscarTutoresPorNombre = tutorContenido.buscarTutoresPorNombre("Erika");
		// Ejercicio TypeQuery Ejemplo 13 nativeQuery parametro

		List<Tutor> buscarTutoresPorApellido = tutorContenido.buscarTutoresPorApellido("Ramos");
		// Ejercicio TypeQuery Ejemplo 14 nativeQuery parametro

		List<Tutor> buscarTutoresPorCorreo = tutorContenido.buscarTutoresPorCorreo("antonxabarca@gmail.com");
		System.out.println(buscarTutoresPorNombre);
		System.out.println(buscarTutoresPorApellido);
		System.out.println(buscarTutoresPorCorreo);
		
		// Ejercicio TypeQuery Ejemplo 15 namedQuery parametro

		List<CursoHasContenidos> buscarCursoHasContenidosPorCurso = curconContenido.buscarCursoHasContenidosPorCurso(nuevo.getIdCurso());
		// Ejercicio TypeQuery Ejemplo 16 namedQuery parametro

		List<CursoHasContenidos> buscarCursoHasContenidosPorContenido = curconContenido.buscarCursoHasContenidosPorContenido(nContenido.getIdContenidos());
		// Ejercicio TypeQuery Ejemplo 17 namedQuery parametro

		List<CursoHasContenidos> buscarCursoHasContenidosPorCursoYContenido = curconContenido.buscarCursoHasContenidosPorCursoYContenido(nuevo.getIdCurso(),nContenido.getIdContenidos());
		System.out.println(buscarCursoHasContenidosPorCurso);
		System.out.println(buscarCursoHasContenidosPorContenido);
		System.out.println(buscarCursoHasContenidosPorCursoYContenido);
		
	}

}
