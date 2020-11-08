package br.com.gerenciadordeincidente.domain.enumeration;

/**
 * The Categoria enumeration.
 */
public enum Categoria {
    VIRTUALIZACAO_DE_DESKTOP(Urgencia.BAIXA), 
    VIRTUALIZACAO_DE_SERVIDORES(Urgencia.ALTA), 
    VIRTUALIZACAO_DE_APLICACOES(Urgencia.ALTA),
    MONITORAMENTO(Urgencia.ALTA), 
    EMAIL(Urgencia.MEDIA), 
    MENSAGEM_INSTANTANEA(Urgencia.BAIXA), 
    TELEFONIA_FIXA(Urgencia.BAIXA), 
    TELEFONIA_MOVEL(Urgencia.MEDIA), 
    INTERNET_MOVEL(Urgencia.MEDIA), 
    IMPRESSAO(Urgencia.BAIXA), 
    CONECTIVIDADE(Urgencia.ALTA), 
    COMPARTILHAMENTO_DE_ARQUIVOS(Urgencia.BAIXA), 
    HOSPEDAGEM_DE_WEBSITES(Urgencia.MEDIA), 
    HOSPEDAGEM_DE_APLICACOES(Urgencia.ALTA), 
    DIRETORIO_USUARIOS(Urgencia.ALTA), 
    BACKUP(Urgencia.ALTA);

    private Urgencia urgencia;

    private Categoria(Urgencia urgencia){
        this.urgencia = urgencia;
    }

    public Urgencia getUrgencia(){
        return this.urgencia;
    }
}
