package com.example.lesson6android1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class StartFragment extends Fragment {
    ArrayList<GameModel> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.start_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sendArrayModel();
            }
        });


    }

    private void sendArrayModel() {
        GameModel model1 = new GameModel("Level 1",
                "https://cutur.ru/wp-content/uploads/_pu/3/59676991.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIcVGt1YznB2SY-NwBOla70YLKZmq1LGGmXg&usqp=CAU",
                "https://s-english.ru/images/likatama/12-4.jpg",
                "https://www.menshairstylesnow.com/wp-content/uploads/2018/03/Best-Mens-Haircuts-For-Thick-Hair-Comb-Over.jpg",
                "Бактыяр");
        GameModel model2 = new GameModel("Level 2",
                "https://images.wbstatic.net/c324x432/new/27110000/27119820-1.jpg",
                "https://www.inform.kz/radmin/news/2020/03/15/200315022010843a3625065i.jpg",
                "https://i.ytimg.com/vi/3IdNb6f-wW4/maxresdefault.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsUNHxZqjSEbN7wExXa4W7O-xZ_p5JSjs4Jg&usqp=CAU",
                "Рустам");
        GameModel model3 = new GameModel("Level 3",
                "https://s.a-5.ru/p/c6/ab/c6abef941fbb2fc1.jpg",
                "https://img.championat.com/news/big/d/v/patch-7-29-dlya-dota-2-dobavil-novogo-geroya-izmenil-kartu-i-balans_1618040102852038523.jpg",
                "https://opt-727458.ssl.1c-bitrix-cdn.ru/upload/iblock/5cf/5cf140ab15f5862e30b1fb6af33435fe.jpg?155256502823782",
                "https://tritec-education.ru/wp-content/uploads/2011/08/java-xxee_thumb.jpg",
                "Баястан");

        list.add(model1);
        list.add(model2);
        list.add(model3);

        Bundle bundle = new Bundle();
        bundle.putSerializable("model", list);
        LevelFragment fragment = new LevelFragment();
        fragment.setArguments(bundle);

        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main,fragment )
                .commit();
    }
}