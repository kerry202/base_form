package com.loan.dai.login;

import com.loan.dai.base.basemodel.BaseModel;
import com.loan.dai.base.baseview.IBaseView;

public interface LoginView extends IBaseView {

    void sendLogin(BaseModel<LoginModel> loginModel);

    void sendSmS(BaseModel<SmSModel> smsModel);


}
