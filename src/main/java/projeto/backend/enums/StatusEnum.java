package projeto.backend.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    ABERTO(0, "Aberto"),
    ANDAMENTO(1, "Andamento"),
    ENCERRADO(2, "Encerrado");

    private final Integer codigo;
    private final String descricao;

    StatusEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static StatusEnum toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (StatusEnum status: StatusEnum.values()) {
            if (cod.equals(status.getCodigo())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + cod);
    }
}