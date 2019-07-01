package com.loan.dai.home;

import com.loan.dai.base.basemodel.BaseModel;
import com.loan.dai.base.baseview.IBaseView;

public interface HomeFragmentView extends IBaseView {

    void getData(BaseModel<String> date);
}
