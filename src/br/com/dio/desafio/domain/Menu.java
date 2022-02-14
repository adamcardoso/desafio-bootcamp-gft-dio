package br.com.dio.desafio.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    Curso curso = new Curso();
    Mentoria mentoria = new Mentoria();
    Bootcamp bootcamp = new Bootcamp();
    Dev developer = new Dev();

    public void chamandoMenu(){
        int opcao = 0;
        do {
            System.out
                    .println("\n\n### Cursos e Mentorias ###");
            System.out.println("                    =========================");
            System.out.println("                  |     1 - Adicionar Curso         |");
            System.out.println("                  |     2 - Adicionar Mentoria      |");
            System.out.println("                  |     3 - Adicionar Bootcamp      |");
            System.out.println("                  |     4 - Adicionar Dev           |");
            System.out.println("                  |     0 - Sair                    |");
            System.out.println("                  =========================");

            System.out.print("Opção: ");
            opcao = input.nextInt();

            System.out.print("\n");
            switch (opcao) {
                case 1:
                    System.out.print("Qual o curso? ");
                    String cursoInserido = input.next();
                    curso.setTitulo(cursoInserido);

                    System.out.print("Qual a descrição do curso? ");
                    String descricaoCurso = input.next();
                    curso.setDescricao(descricaoCurso);
                    input.nextLine();

                    try {
                        System.out.print("Qual a carga horária? ");
                        int inserindoCargaHoraria = input.nextInt();
                        curso.setCargaHoraria(inserindoCargaHoraria);
                    } catch (InputMismatchException e) {
                        System.err.print("Ops... você digitou caracteres. Precisamos que digite apenas números.");
                    }
                    break;

                case 2:
                    System.out.print("Sobre o que é a mentoria? ");
                    String insereMentoria = input.next();
                    mentoria.setTitulo(insereMentoria);

                    input.nextLine();

                    System.out.print("Descreva a mentoria: ");
                    String descreveMentoria = input.next();
                    mentoria.setDescricao(descreveMentoria);
                    input.nextLine();
                    break;

                case 3:
                    System.out.println("Qual o nome do bootcamp (Ex.: Bootcamp Java Developer)? ");
                    String nomeBootcamp = input.next();
                    bootcamp.setNome(nomeBootcamp);

                    input.nextLine();

                    System.out.println("Descreva o bootcamp: ");
                    String descricaoBootcamp = input.next();
                    bootcamp.setDescricao(descricaoBootcamp);

                    bootcamp.getConteudos().add(curso);
                    bootcamp.getConteudos().add(curso);
                    bootcamp.getConteudos().add(mentoria);
                    input.nextLine();

                    break;

                case 4:
                    System.out.println("Qual o nome do developer: ");
                    String nomeDev = input.next();
                    developer.setNome(nomeDev);
                    developer.inscreverBootcamp(bootcamp);

                    System.out.printf("Conteúdos inscritos por %s\n: ", nomeDev, developer.getConteudosInscritos());
                    developer.progredir();
                    developer.progredir();
                    System.out.println("-");
                    System.out.printf("Conteúdos inscritos por %s\n: ", nomeDev, developer.getConteudosInscritos());
                    System.out.printf("Conteúdos inscritos por %s\n: ", nomeDev, developer.getConteudosInscritos());
                    System.out.println("XP:" + developer.calcularTotalXP());
                    break;

                case 5:

                    break;

                case 0:
                    System.out.println("Você está saindo do sistema! Obrigado!");
                    break;

                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    public void teste(){
        Curso curso1 = new Curso();

        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXP());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXP());
    }
}
