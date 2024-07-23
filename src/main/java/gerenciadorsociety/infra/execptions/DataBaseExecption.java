package gerenciadorsociety.infra.execptions;

public class DataBaseExecption extends RuntimeException {
    public DataBaseExecption(String mensge) {
        super(mensge);
    }
}
