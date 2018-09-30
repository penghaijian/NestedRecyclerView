package com.zzeng.nestedrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nested_rv)
    RecyclerView mNestedRv;

    private List<Object> mDataList = new ArrayList<>();
    private NestedAdapter mNestedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initAdapter();
        initData();
    }

    private void initAdapter() {
        mNestedAdapter = new NestedAdapter(this, mDataList);
        final GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mDataList.get(position) instanceof Head) {
                    return manager.getSpanCount();
                } else if (mDataList.get(position) instanceof Content) {
                    return 1;
                } else if (mDataList.get(position) instanceof Foot) {
                    return manager.getSpanCount();
                }
                return 1;
            }
        });
        mNestedRv.setLayoutManager(manager);
        mNestedRv.setAdapter(mNestedAdapter);
        mNestedAdapter.setOnItemClickListener(new NestedAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (((Content) mDataList.get(position)).getClass() != null) {
                    startActivity(new Intent(MainActivity.this, ((Content) mDataList.get(position)).getClass()));
                } else {
                    Toast.makeText(MainActivity.this, ((Content) mDataList.get(position)).getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initData() {
        String json = "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"name\": \"A\",\n" +
                "            \"id\": \"1201\",\n" +
                "            \"child\": [\n" +
                "                {\n" +
                "                    \"name\": \"A1\",\n" +
                "                    \"id\": \"120101\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"A2\",\n" +
                "                    \"id\": \"120102\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"A3\",\n" +
                "                    \"id\": \"120103\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"A4\",\n" +
                "                    \"id\": \"120104\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"A5\",\n" +
                "                    \"id\": \"120105\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"B\",\n" +
                "            \"id\": \"1202\",\n" +
                "            \"child\": [\n" +
                "                {\n" +
                "                    \"name\": \"B1\",\n" +
                "                    \"id\": \"120201\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"B2\",\n" +
                "                    \"id\": \"120202\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"B3\",\n" +
                "                    \"id\": \"120203\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"C\",\n" +
                "            \"id\": \"1001203\",\n" +
                "            \"child\": [\n" +
                "                {\n" +
                "                    \"name\": \"C1\",\n" +
                "                    \"id\": \"120301\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"C2\",\n" +
                "                    \"id\": \"120302\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"C3\",\n" +
                "                    \"id\": \"120303\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"C4\",\n" +
                "                    \"id\": \"120304\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"C5\",\n" +
                "                    \"id\": \"120305\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"C6\",\n" +
                "                    \"id\": \"120306\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"D\",\n" +
                "            \"id\": \"1001204\",\n" +
                "            \"child\": [\n" +
                "                {\n" +
                "                    \"name\": \"D1\",\n" +
                "                    \"id\": \"120401\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"D2\",\n" +
                "                    \"id\": \"120402\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"D3\",\n" +
                "                    \"id\": \"120403\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"D4\",\n" +
                "                    \"id\": \"120404\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"D5\",\n" +
                "                    \"id\": \"120405\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"E\",\n" +
                "            \"id\": \"1001205\",\n" +
                "            \"child\": [\n" +
                "                {\n" +
                "                    \"name\": \"E1\",\n" +
                "                    \"id\": \"120501\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"E2\",\n" +
                "                    \"id\": \"120502\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"E3\",\n" +
                "                    \"id\": \"120503\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"E4\",\n" +
                "                    \"id\": \"120504\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"E5\",\n" +
                "                    \"id\": \"120505\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"E6\",\n" +
                "                    \"id\": \"120506\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"E7\",\n" +
                "                    \"id\": \"120507\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"responseCode\": \"0000\",\n" +
                "    \"isSuccess\": true,\n" +
                "    \"responseMsg\": \"ok\"\n" +
                "}\n" +
                "\n";
        NetBean netBean = new Gson().fromJson(json, NetBean.class);
        List<Head> mGroupList = new ArrayList<>();
        for (NetBean.DataBean parentBean : netBean.getData()) {
            Head group = new Head();
            List<Content> mTempList = new ArrayList<>();
            for (NetBean.DataBean.ChildBean childBean : parentBean.getChild()) {
                //遍历每个group 组装数据
                Content reportLabel = new Content(null, childBean.getId(), childBean.getName(),
                        R.mipmap.ic_content_logo);
                mTempList.add(reportLabel);
            }
            group.setHeadName(parentBean.getName());
            group.setContentList(mTempList);
            mGroupList.add(group);
        }
        mDataList.addAll(getDataReload(mGroupList));
        mNestedAdapter.notifyDataSetChanged();

    }

    public static List<Object> getDataReload(List<Head> mGroupList) {
        List<Object> mDataList = new ArrayList<>();

        //遍历每个标签块
        for (Head group : mGroupList) {
            mDataList.add(group);
            mDataList.addAll(group.getContentList());
            mDataList.add(new Foot());
        }
        return mDataList;
    }
}
