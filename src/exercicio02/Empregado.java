package exercicio02;

// utilizado em padrão de projeto DTO (Data Transfer Object),
// onde o objetivo é apenas transferir um objeto sem permitir que seus dados sejam alterados
public record Empregado(String nome, int anosExperiencia, double salario) {
    record map() {

    }
}

