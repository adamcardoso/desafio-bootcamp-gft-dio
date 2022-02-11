import br.com.dio.desafio.domain.Curso;
import br.com.dio.desafio.domain.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();
        Curso curso1 = new Curso();

        curso.setTitulo("Curso de Java");
        curso.setDescricao("descrição curso Java");
        curso.setCargaHoraria(8);

        curso1.setTitulo("Curso de JavaScript");
        curso1.setDescricao("descrição curso JavaScript");
        curso1.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de Java");
        mentoria.setDescricao("descrição mentoria Java");
        mentoria.setData(LocalDate.now());


        System.out.println(curso);
        System.out.println(curso1);
        System.out.println(mentoria);

    }
}
