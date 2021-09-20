package com.example.cat_pinyin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.media.SoundPool;
import android.widget.PopupWindow;



public class MainActivity extends Activity {
    public ImageView[] ShowPhonetic = new ImageView[4]; //注音和音調顯示位置的儲存格陣列
    public ImageView[] ShowImage = new ImageView[2]; //顯示例子詞和圖位置的儲存格陣列
    SoundPool Pronounce;  //聲音播放裝置

    public int PhoneticQuantity = 38; //注音數量
    public int[] PhoneticPronounceID = new int[PhoneticQuantity]; //注音發音處存格
    int[] PhoneticPronunciationPosition = { //注音發音位置處存格
            0,
            R.raw.a,
            R.raw.b,
            R.raw.c,
            R.raw.d,
            R.raw.e,
            R.raw.f,
            R.raw.g,
            R.raw.h,
            R.raw.i,
            R.raw.j,
            R.raw.k,
            R.raw.l,
            R.raw.m,
            R.raw.n,
            R.raw.o,
            R.raw.p,
            R.raw.q,
            R.raw.r,
            R.raw.s,
            R.raw.t,
            R.raw.u,
            R.raw.y,
            R.raw.z,
            R.raw.aa,
            R.raw.ab,
            R.raw.ac,
            R.raw.ad,
            R.raw.ae,
            R.raw.af,
            R.raw.ag,
            R.raw.ah,
            R.raw.ai,
            R.raw.aj,
            R.raw.ak,
            R.raw.v,
            R.raw.w,
            R.raw.x,
    };

    public int WordQuantity = 55; //單詞數量
    public int[] WordPronounceID = new int[WordQuantity]; //單詞發音處存格
    int[] WordPronunciation = { //單詞發音位置處存格
            //ㄅ開頭
            R.raw.example_1_0_1_0,
            R.raw.example_1_0_1_1,
            R.raw.example_1_0_1_2,
            R.raw.example_1_0_1_3,
            R.raw.example_1_0_1_4,
            R.raw.example_1_0_2_0,
            R.raw.example_1_0_2_1,
            R.raw.example_1_0_2_2,
            R.raw.example_1_0_2_3,
            R.raw.example_1_0_2_4,
            R.raw.example_1_0_5_0,
            R.raw.example_1_0_5_2,
            R.raw.example_1_0_5_3,
            R.raw.example_1_0_5_4,
            R.raw.example_1_0_6_0,
            R.raw.example_1_0_6_3,
            R.raw.example_1_0_6_4,
            R.raw.example_1_0_7_0,
            R.raw.example_1_0_7_2,
            R.raw.example_1_0_7_3,
            R.raw.example_1_0_7_4,
            R.raw.example_1_0_9_0,
            R.raw.example_1_0_9_3,
            R.raw.example_1_0_9_4,
            R.raw.example_1_0_10_0,
            R.raw.example_1_0_10_3,
            R.raw.example_1_0_10_4,
            R.raw.example_1_0_11_0,
            R.raw.example_1_0_11_3,
            R.raw.example_1_0_11_4,
            R.raw.example_1_0_12_0,
            R.raw.example_1_0_12_2,
            R.raw.example_1_0_12_3,
            R.raw.example_1_0_12_4,
            R.raw.example_1_1_0_0,
            R.raw.example_1_1_0_2,
            R.raw.example_1_1_0_3,
            R.raw.example_1_1_0_4,
            R.raw.example_1_1_4_0,
            R.raw.example_1_1_4_2,
            R.raw.example_1_1_4_3,
            R.raw.example_1_1_4_4,
            R.raw.example_1_1_7_0,
            R.raw.example_1_1_7_3,
            R.raw.example_1_1_7_4,
            R.raw.example_1_1_9_0,
            R.raw.example_1_1_9_3,
            R.raw.example_1_1_9_4,
            R.raw.example_1_1_10_0,
            R.raw.example_1_1_10_4,
            R.raw.example_1_1_12_0,
            R.raw.example_1_1_12_3,
            R.raw.example_1_1_12_4,
            R.raw.example_1_2_0_0,
            R.raw.example_1_2_0_3,
            R.raw.example_1_2_0_4,
            //待加入
    };

    public int SingleWord = 82; //單辭數量
    public int[] SingleWordPronounceID = new int[SingleWord]; //注音發音處存格
    int[] SingleWordPronunciation = { //注音發音位置處存格
            R.raw.no,
            //ㄅ開頭
            R.raw.word_1_0_0_0,
            R.raw.word_1_0_1_0,
            R.raw.word_1_0_1_1,
            R.raw.word_1_0_1_2,
            R.raw.word_1_0_1_3,
            R.raw.word_1_0_1_4,
            R.raw.word_1_0_2_0,
            R.raw.word_1_0_2_1,
            R.raw.word_1_0_2_2,
            R.raw.word_1_0_2_3,
            R.raw.word_1_0_2_4,
            R.raw.word_1_0_5_0,
            R.raw.word_1_0_5_1,
            R.raw.word_1_0_5_2,
            R.raw.word_1_0_5_3,
            R.raw.word_1_0_5_4,
            R.raw.word_1_0_6_0,
            R.raw.word_1_0_6_1,
            R.raw.word_1_0_6_2,
            R.raw.word_1_0_6_3,
            R.raw.word_1_0_6_4,
            R.raw.word_1_0_7_0,
            R.raw.word_1_0_7_1,
            R.raw.word_1_0_7_2,
            R.raw.word_1_0_7_3,
            R.raw.word_1_0_7_4,
            R.raw.word_1_0_9_0,
            R.raw.word_1_0_9_1,
            R.raw.word_1_0_9_2,
            R.raw.word_1_0_9_3,
            R.raw.word_1_0_9_4,
            R.raw.word_1_0_10_0,
            R.raw.word_1_0_10_1,
            R.raw.word_1_0_10_2,
            R.raw.word_1_0_10_3,
            R.raw.word_1_0_10_4,
            R.raw.word_1_0_11_0,
            R.raw.word_1_0_11_1,
            R.raw.word_1_0_11_2,
            R.raw.word_1_0_11_3,
            R.raw.word_1_0_11_4,
            R.raw.word_1_0_12_0,
            R.raw.word_1_0_12_1,
            R.raw.word_1_0_12_2,
            R.raw.word_1_0_12_3,
            R.raw.word_1_0_12_4,
            R.raw.word_1_1_0_0,
            R.raw.word_1_1_0_1,
            R.raw.word_1_1_0_2,
            R.raw.word_1_1_0_3,
            R.raw.word_1_1_0_4,
            R.raw.word_1_1_4_0,
            R.raw.word_1_1_4_1,
            R.raw.word_1_1_4_2,
            R.raw.word_1_1_4_3,
            R.raw.word_1_1_4_4,
            R.raw.word_1_1_7_0,
            R.raw.word_1_1_7_1,
            R.raw.word_1_1_7_2,
            R.raw.word_1_1_7_3,
            R.raw.word_1_1_7_4,
            R.raw.word_1_1_9_0,
            R.raw.word_1_1_9_1,
            R.raw.word_1_1_9_2,
            R.raw.word_1_1_9_3,
            R.raw.word_1_1_9_4,
            R.raw.word_1_1_10_0,
            R.raw.word_1_1_10_1,
            R.raw.word_1_1_10_2,
            R.raw.word_1_1_10_3,
            R.raw.word_1_1_10_4,
            R.raw.word_1_1_12_0,
            R.raw.word_1_1_12_1,
            R.raw.word_1_1_12_2,
            R.raw.word_1_1_12_3,
            R.raw.word_1_1_12_4,
            R.raw.word_1_2_0_0,
            R.raw.word_1_2_0_1,
            R.raw.word_1_2_0_2,
            R.raw.word_1_2_0_3,
            R.raw.word_1_2_0_4,
            //待加入
    };

    int[] PhoneticPictures = {  //注音照片位置處存格
            R.drawable.nu,
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.s,
            R.drawable.t,
            R.drawable.u,
            R.drawable.y,
            R.drawable.z,
            R.drawable.aa,
            R.drawable.ab,
            R.drawable.ac,
            R.drawable.ad,
            R.drawable.ae,
            R.drawable.af,
            R.drawable.ag,
            R.drawable.ah,
            R.drawable.ai,
            R.drawable.aj,
            R.drawable.ak,
            R.drawable.v,
            R.drawable.w,
            R.drawable.x,
            R.drawable.al,
            R.drawable.am,
            R.drawable.an,
            R.drawable.ao,
            R.drawable.ap,
            R.drawable.follow,
    };

    public int SingleWordPhotoQuantity = 55; //單辭照片數量
    int[] SingleWordPhoto = { //單辭照片位置處存格
            //ㄅ開頭
            R.drawable.wordcard_1_0_1_0,
            R.drawable.wordcard_1_0_1_1,
            R.drawable.wordcard_1_0_1_2,
            R.drawable.wordcard_1_0_1_3,
            R.drawable.wordcard_1_0_1_4,
            R.drawable.wordcard_1_0_2_0,
            R.drawable.wordcard_1_0_2_1,
            R.drawable.wordcard_1_0_2_2,
            R.drawable.wordcard_1_0_2_3,
            R.drawable.wordcard_1_0_2_4,
            R.drawable.wordcard_1_0_5_0,
            R.drawable.wordcard_1_0_5_2,
            R.drawable.wordcard_1_0_5_3,
            R.drawable.wordcard_1_0_5_4,
            R.drawable.wordcard_1_0_6_0,
            R.drawable.wordcard_1_0_6_3,
            R.drawable.wordcard_1_0_6_4,
            R.drawable.wordcard_1_0_7_0,
            R.drawable.wordcard_1_0_7_2,
            R.drawable.wordcard_1_0_7_3,
            R.drawable.wordcard_1_0_7_4,
            R.drawable.wordcard_1_0_9_0,
            R.drawable.wordcard_1_0_9_3,
            R.drawable.wordcard_1_0_9_4,
            R.drawable.wordcard_1_0_10_0,
            R.drawable.wordcard_1_0_10_3,
            R.drawable.wordcard_1_0_10_4,
            R.drawable.wordcard_1_0_11_0,
            R.drawable.wordcard_1_0_11_3,
            R.drawable.wordcard_1_0_11_4,
            R.drawable.wordcard_1_0_12_0,
            R.drawable.wordcard_1_0_12_2,
            R.drawable.wordcard_1_0_12_3,
            R.drawable.wordcard_1_0_12_4,
            R.drawable.wordcard_1_1_0_0,
            R.drawable.wordcard_1_1_0_2,
            R.drawable.wordcard_1_1_0_3,
            R.drawable.wordcard_1_1_0_4,
            R.drawable.wordcard_1_1_4_0,
            R.drawable.wordcard_1_1_4_2,
            R.drawable.wordcard_1_1_4_3,
            R.drawable.wordcard_1_1_4_4,
            R.drawable.wordcard_1_1_7_0,
            R.drawable.wordcard_1_1_7_3,
            R.drawable.wordcard_1_1_7_4,
            R.drawable.wordcard_1_1_9_0,
            R.drawable.wordcard_1_1_9_3,
            R.drawable.wordcard_1_1_9_4,
            R.drawable.wordcard_1_1_10_0,
            R.drawable.wordcard_1_1_10_4,
            R.drawable.wordcard_1_1_12_0,
            R.drawable.wordcard_1_1_12_3,
            R.drawable.wordcard_1_1_12_4,
            R.drawable.wordcard_1_2_0_0,
            R.drawable.wordcard_1_2_0_3,
            R.drawable.wordcard_1_2_0_4,
            //待加入
    };

    public int SingleWordPictureQuantity = 55; //單辭圖片數量
    int[] SingleWordPicture = { //單辭圖片位置處存格
            //ㄅ開頭
            R.drawable.image_1_0_1_0,
            R.drawable.image_no,
            R.drawable.image_1_0_1_2,
            R.drawable.image_1_0_1_3,
            R.drawable.image_1_0_1_4,
            R.drawable.image_1_0_2_0,
            R.drawable.image_1_0_2_1,
            R.drawable.image_1_0_2_2,
            R.drawable.image_no,
            R.drawable.image_1_0_2_4,
            R.drawable.image_no,
            R.drawable.image_1_0_5_2,
            R.drawable.image_1_0_5_3,
            R.drawable.image_1_0_5_4,
            R.drawable.image_1_0_6_0,
            R.drawable.image_1_0_6_3,
            R.drawable.image_1_0_6_4,
            R.drawable.image_1_0_7_0,
            R.drawable.image_1_0_7_2,
            R.drawable.image_1_0_7_3,
            R.drawable.image_1_0_7_4,
            R.drawable.image_1_0_9_0,
            R.drawable.image_1_0_9_3,
            R.drawable.image_1_0_9_4,
            R.drawable.image_1_0_10_0,
            R.drawable.image_1_0_10_3,
            R.drawable.image_no,
            R.drawable.image_1_0_11_0,
            R.drawable.image_1_0_11_3,
            R.drawable.image_1_0_11_4,
            R.drawable.image_1_0_12_0,
            R.drawable.image_no,
            R.drawable.image_no,
            R.drawable.image_1_0_12_4,
            R.drawable.image_no,
            R.drawable.image_1_1_0_2,
            R.drawable.image_1_1_0_3,
            R.drawable.image_no,
            R.drawable.image_1_1_4_0,
            R.drawable.image_1_1_4_2,
            R.drawable.image_no,
            R.drawable.image_no,
            R.drawable.image_no,
            R.drawable.image_1_1_7_3,
            R.drawable.image_no,
            R.drawable.image_1_1_9_0,
            R.drawable.image_1_1_9_3,
            R.drawable.image_1_1_9_4,
            R.drawable.image_1_1_10_0,
            R.drawable.image_1_1_10_4,
            R.drawable.image_1_1_12_0,
            R.drawable.image_1_1_12_3,
            R.drawable.image_1_1_12_4,
            R.drawable.image_no,
            R.drawable.image_1_2_0_3,
            R.drawable.image_no,
            //待加入
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Pronounce = new SoundPool.Builder().build(); //將注音發音位置處理後轉進注音發音處存格
        for(int j=1; j < PhoneticQuantity; j++){
            PhoneticPronounceID[j] = Pronounce.load(this, PhoneticPronunciationPosition[j], 1);
        }
        for(int j=0; j < WordQuantity; j++){
            WordPronounceID[j] = Pronounce.load(this, WordPronunciation[j], 1);
        }
        for(int j=0; j < SingleWord; j++){
            SingleWordPronounceID[j] = Pronounce.load(this, SingleWordPronunciation[j], 1);
        }

        ShowPhonetic[0] = findViewById(R.id.ButtonView1);
        ShowPhonetic[1] = findViewById(R.id.ButtonView2);
        ShowPhonetic[2] = findViewById(R.id.ButtonView3);
        ShowPhonetic[3] = findViewById(R.id.ButtonView4);

        ZhuyinArrayIndex = 0;
        ShowPhonetic[0].setImageResource(PhoneticPictures[43]);
        ShowPhonetic[3].setImageResource(PhoneticPictures[0]);
        ToneArray = -1;
        for(int j=0; j < 3; j++){
            PhoneticArray[j] = -1;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        View decorView = getWindow().getDecorView(); //全螢幕處理
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }


    public int ZhuyinArrayIndex; //注音陣列指標
    public int[] PhoneticArray = new int[3]; //注音儲存陣列
    public int ToneArray; //音調儲存格

    @SuppressLint("SetTextI18n")
    public void push(View view){
        int number = Integer.parseInt(view.getTag().toString()); //回傳的按鍵鍵值
        if(number <= 37){
            if(ZhuyinArrayIndex < 3 && ZhuyinArrayIndex >= 0){
                ShowPhonetic[ZhuyinArrayIndex].setImageResource(PhoneticPictures[number]);
                Pronounce.play(PhoneticPronounceID[number], 1.0F, 1.0F, 0, 0, 1.0F);
                PhoneticArray[ZhuyinArrayIndex] = number;
                int check = 0; //紀錄檢查有無找到空陣列
                for(int j=ZhuyinArrayIndex; j < 3; j++){ //尋找後方有無空陣列
                    if(PhoneticArray[j] == -1){
                        ZhuyinArrayIndex = j;
                        ShowPhonetic[ZhuyinArrayIndex].setImageResource(PhoneticPictures[43]);
                        check = 1;
                        break;
                    }
                }
                if(check == 0){
                    for(int j=0; j < ZhuyinArrayIndex; j++){ //尋找前方有無空陣列
                        if(PhoneticArray[j] == -1){
                            ZhuyinArrayIndex = j;
                            ShowPhonetic[ZhuyinArrayIndex].setImageResource(PhoneticPictures[43]);
                            check = 1;
                            break;
                        }
                    }
                }
                if(check == 0){ //都沒有就設ZhuyinArrayIndex為-1
                    ZhuyinArrayIndex = -1;
                }
            }
        }
        else{
            ToneArray = number;
            ShowPhonetic[3].setImageResource(PhoneticPictures[number]);
        }
        ReaderCheck = 0;
        if(CheckShowPicture == 1) {
            CheckShowPicture = 0;
            CloseShowPicture();
        }
    }

    private PopupWindow SubWindow; //顯示小視窗的工具
    public void showDialog(View view3) { //顯示單辭小視窗
        View view2 = findViewById(R.id.view);
        @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        SubWindow = new PopupWindow(view,view2.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
        ShowImage[0] = view.findViewById(R.id.ExampleImage);
        ShowImage[1] = view.findViewById(R.id.ExampleWord);
        ShowImage[0].setImageResource(SingleWordPicture[SingularIndex[1]]);
        ShowImage[1].setImageResource(SingleWordPhoto[SingularIndex[1]]);
        SubWindow.update();
        SubWindow.showAtLocation(view2,0, (int)view2.getX(),(int)view2.getY());
        Pronounce.play(WordPronounceID[SingularIndex[1]], 1.0F, 1.0F, 0, 0, 1.0F);
    }
    public void CloseShowDialog(View view){ //關閉小視窗
        SubWindow.dismiss();
    }

    private PopupWindow SubPicture; //顯示照片按鈕的工具
    public int CheckShowPicture = 0;
    public void showPicture() { //顯示照片按鈕的小視窗

        View view2 = findViewById(R.id.view2);
        @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.picture_button, null);
        SubPicture = new PopupWindow(view,view2.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
        SubPicture.showAtLocation(view2,0,(int)view2.getX(),(int)view2.getY());

        CheckShowPicture = 1;
    }
    public void CloseShowPicture(){
        SubPicture.dismiss();
    }

    public void check(View view){ //刪掉或將注音指標掉到陣列處存格
        int number = Integer.parseInt(view.getTag().toString())-1; //回傳的按鍵鍵值
        if(number < 3){ //檢查按下的是注音格還是音調格
            if(PhoneticArray[number] != -1){ //檢查此陣列格有無鍵值，有，刪除
                ShowPhonetic[number].setImageResource(PhoneticPictures[0]);
                PhoneticArray[number] = -1;
            }
            else{
                if(ZhuyinArrayIndex != -1){ //此陣列格無鍵值，將注音指標指向它
                    ShowPhonetic[ZhuyinArrayIndex].setImageResource(PhoneticPictures[0]);
                }
                ShowPhonetic[number].setImageResource(PhoneticPictures[43]);
                ZhuyinArrayIndex = number;
            }
        }
        else{
            if(ToneArray != -1){
                ShowPhonetic[3].setImageResource(PhoneticPictures[0]);
                ToneArray = -1;
            }
        }
        ReaderCheck = 0;
        if(CheckShowPicture == 1) {
            CheckShowPicture = 0;
            CloseShowPicture();
        }
    }

    public void clear(View view){ //清除所有數值
        ZhuyinArrayIndex = 0;
        for(int j=0; j < 3; j++){
            ShowPhonetic[j].setImageResource(PhoneticPictures[0]);
            PhoneticArray[j] = -1;
        }
        ToneArray = -1;
        ShowPhonetic[0].setImageResource(PhoneticPictures[43]);
        ShowPhonetic[3].setImageResource(PhoneticPictures[0]);
        ReaderCheck = 0;
        if(CheckShowPicture == 1) {
            CheckShowPicture = 0;
            CloseShowPicture();
        }
    }

    public int ReaderCheck = 0;
    public int[] SingularIndex = new int[2];
    public int SearchQuantity = 0; //搜尋數量
    public int[] SearchArray = new int[4]; //搜尋用陣列
    public void reader(View view){ //搜尋有無此音和單辭
        if(ReaderCheck == 0){
            SearchQuantity = 0;
            for(int j=0; j < 3; j++){ //將注音陣列有的注音放入搜索陣列
                if(PhoneticArray[j] != -1){
                    SearchArray[SearchQuantity] = PhoneticArray[j];
                    SearchQuantity++;
                }
            }
            if(SearchQuantity == 0){
                //放出錯誤的音效
                Pronounce.play(SingleWordPronounceID[0], 1.0F, 1.0F, 0, 0, 1.0F);
                return;
            }
            for(int j=SearchQuantity; j < 3; j++){ //將沒有注音的搜索陣列格放入-1
                SearchArray[j] = -1;
            }
            SearchArray[3] = ToneArray;
            SingularIndex = Pinyin.pinyin(SearchArray, SearchQuantity);
            if(SingularIndex[0] != -1){ //是否找到相同的音，是，放出音
                ReaderCheck = 1;
                Pronounce.play(SingleWordPronounceID[SingularIndex[0]], 1.0F, 1.0F, 0, 0, 1.0F);
            }
            else{ //放出沒有的音效
                ReaderCheck = 1;
                Pronounce.play(SingleWordPronounceID[0], 1.0F, 1.0F, 0, 0, 1.0F);
            }

            if(SingularIndex[1] != -1){ //是否找到相同的單辭，是，放出小視窗按鈕
                //ShowPhonetic[0].setImageResource(SingleWordPicture[SingularIndex[1]]);
                //ShowPhonetic[1].setImageResource(SingleWordPhoto[SingularIndex[1]]);

                showPicture();
            }
        }
        else{
            if(SingularIndex[0] != -1){ //是否找到相同的音
                Pronounce.play(SingleWordPronounceID[SingularIndex[0]], 1.0F, 1.0F, 0, 0, 1.0F);
            }
            else{ //放出沒有的音效
                Pronounce.play(SingleWordPronounceID[0], 1.0F, 1.0F, 0, 0, 1.0F);
            }
        }
    }
}

