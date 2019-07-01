package com.loan.dai.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.loan.dai.R;
import com.loan.dai.base.BaseActivity;
import com.loan.dai.base.LoanApp;
import com.loan.dai.base.WebActivity;
import com.loan.dai.base.basemodel.BaseModel;
import com.loan.dai.logs.Logs;
import com.loan.dai.utils.FormatUtil;
import com.loan.dai.utils.ProgressUtil;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView, View.OnClickListener {


    private ImageView leftArrows;
    private ImageView rightArrows;
    private TextView title;
    private TextView sendCode;
    private TextView deal;
    private Button login;
    private EditText verifitionCode;
    private EditText phoneNumber;

    private int num = 10;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (num > 0) {
                num--;
                mHandler.sendEmptyMessageDelayed(1, 1000);
                sendCode.setText(num + "后重新发送");
                sendCode.setBackgroundColor(LoanApp.mContext.getResources().getColor(R.color.white));
                sendCode.setTextColor(LoanApp.mContext.getResources().getColor(R.color.text_gray_8181));
            } else {
                num = 10;
                sendCode.setClickable(true);
                sendCode.setText(LoanApp.mContext.getResources().getString(R.string.txt_get_code));
                sendCode.setBackground(LoanApp.mContext.getResources().getDrawable(R.drawable.bg_circle_bule_white));
                sendCode.setTextColor(LoanApp.mContext.getResources().getColor(R.color.bg_bule_1b6));
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);

        mPresenter.sendSms();
        initView();

    }

    private boolean isPhoneNumber;
    private boolean isCode;

    private void initView() {

        leftArrows = findViewById(R.id.title_left_arrows);
        rightArrows = findViewById(R.id.login_right_arrows_iv);
        title = findViewById(R.id.title_right_tv);
        sendCode = findViewById(R.id.login_sendcode_iv);
        login = findViewById(R.id.login_bt);
        verifitionCode = findViewById(R.id.login_input_code_et);
        phoneNumber = findViewById(R.id.login_input_phonenum);
        deal = findViewById(R.id.login_deal_tv);
        title.setVisibility(View.VISIBLE);
        String dealStr1 = getResources().getString(R.string.txt_login_deal1);
        String dealStr2 = getResources().getString(R.string.txt_login_deal2);
        Spanned format = FormatUtil.format(dealStr1, dealStr2, "#1B65DF");
        deal.setText(format);

        title.setOnClickListener(this);
        leftArrows.setOnClickListener(this);
        sendCode.setOnClickListener(this);
        rightArrows.setOnClickListener(this);
        login.setOnClickListener(this);
        deal.setOnClickListener(this);

        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString() != null && charSequence.toString().length() == 11) {
                    isPhoneNumber = true;
                } else {
                    isPhoneNumber = false;
                    login.setBackground(LoanApp.mContext.getResources().getDrawable(R.drawable.bg_circle_gray));
                }

                if (isPhoneNumber && isCode) {
                    login.setBackground(LoanApp.mContext.getResources().getDrawable(R.drawable.bg_circle_bule));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        verifitionCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString() != null && charSequence.toString().length() == 4) {
                    isCode = true;
                } else {
                    isCode = false;
                    login.setBackground(LoanApp.mContext.getResources().getDrawable(R.drawable.bg_circle_gray));
                }
                if (isPhoneNumber && isCode) {
                    login.setBackground(LoanApp.mContext.getResources().getDrawable(R.drawable.bg_circle_bule));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void sendLogin(BaseModel<LoginModel> loginModel) {
        Logs.s("  loginModel  " + loginModel);
    }

    @Override
    public void sendSmS(BaseModel<SmSModel> smsModel) {

    }

    @Override
    public void showLoading() {
        ProgressUtil.showDialog(this);
    }

    @Override
    public void hideLoading() {
        ProgressUtil.dismiss();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_bt:
                mPresenter.sendLogin();
                break;

            case R.id.title_right_tv:

                break;
            case R.id.login_sendcode_iv:
                verifitionCode.setText("");
                sendCode.setClickable(false);
                mHandler.sendEmptyMessageDelayed(0, 1000);
                break;
            case R.id.login_right_arrows_iv:
                phoneNumber.setText("");
                break;
            case R.id.title_left_arrows:
                finish();
                break;
            case R.id.login_deal_tv:
                Intent intent = new Intent(this, WebActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(null);
    }
}
