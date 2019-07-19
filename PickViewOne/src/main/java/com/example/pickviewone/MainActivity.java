package com.example.pickviewone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewAddress;

    OptionsPickerView pvOptions;
    //  路程车费
    ArrayList<String> salaryBeanList = new ArrayList<>();//这是存放对象的列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  创建选项选择器
        pvOptions = new OptionsPickerView(this);
        mTextViewAddress = (TextView) findViewById(R.id.tv_address);

        //  获取json数据
        String roadcash_data_json = JsonFileReader.getJson(this, "roadcash.json");
        //  解析json数据
        parseJson(roadcash_data_json);

        //  设置三级联动效果
        pvOptions.setPicker(salaryBeanList, null, null, false);


        //  设置选择的三级单位
        //pvOptions.setLabels("省", "市", "区");
        //pvOptions.setTitle("选择城市");

        //  设置是否循环滚动
        pvOptions.setCyclic(false, false, false);


        // 设置默认选中的三级项目
        pvOptions.setSelectOptions(0, 0, 0);
        //  监听确定选择按钮
        pvOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String salary;
                salary = salaryBeanList.get(options1);
                mTextViewAddress.setText(salary);
            }
        });
        //  点击弹出选项选择器
        mTextViewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvOptions.show();
            }
        });
    }
    //  解析json填充集合
    public void parseJson(String str) {
        try {
            //  获取json中的数组
            JSONArray jsonArray = new JSONArray(str);
            //  遍历数据组
            for (int i = 0; i < jsonArray.length(); i++) {
                //  获取路程车费的对象
                JSONObject salaryObject = jsonArray.optJSONObject(i);
                //  获取路程车费名称放入集合
                String salaryName = salaryObject.getString("name");
                salaryBeanList.add(salaryName);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
