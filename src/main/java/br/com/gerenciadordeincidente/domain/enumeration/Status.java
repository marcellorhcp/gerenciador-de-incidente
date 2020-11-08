package br.com.gerenciadordeincidente.domain.enumeration;

/**
 * The Status enumeration.
 */
public enum Status {
    ABERTO(1), 
    ATRIBUIDO(2), 
    EM_ATENDIMENTO(3), 
    AGUARDANDO_USUARIO(4), 
    AGUARDANDO_TERCEIRO(5), 
    RESOLVIDO(6), 
    FECHADO(7);
	
	private int ordem;

	private Status(int ordem) {
		this.ordem = ordem;
	}
	
	public int getOrdem() {
		return ordem;
	}
}
