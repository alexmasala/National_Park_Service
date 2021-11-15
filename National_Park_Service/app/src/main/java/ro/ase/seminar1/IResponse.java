package ro.ase.seminar1;

import java.util.List;

public interface IResponse {
    public void onSuccess(List<Parc> list);
    public void onError(String errorMessage);

}
