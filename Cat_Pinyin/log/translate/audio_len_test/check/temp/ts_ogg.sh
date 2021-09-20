#char a[21][5] = {"ㄅ","ㄆ","ㄇ","ㄈ","ㄉ","ㄊ","ㄋ","ㄌ","ㄍ","ㄎ","ㄏ","ㄐ","ㄑ","ㄒ","ㄓ","ㄔ","ㄕ","ㄖ","ㄗ","ㄘ","ㄙ"};
#char b[3][5] = {"一","ㄨ","ㄩ"};
#char c[13][5] = {"ㄚ","ㄛ","ㄜ","ㄝ","ㄞ","ㄟ","ㄠ","ㄡ","ㄢ","ㄣ","ㄤ","ㄥ","ㄦ"};

a=("" "ㄅ" "ㄆ" "ㄇ" "ㄈ" "ㄉ" "ㄊ" "ㄋ" "ㄌ" "ㄍ" "ㄎ" "ㄏ" "ㄐ" "ㄑ" "ㄒ" "ㄓ" "ㄔ" "ㄕ" "ㄖ" "ㄗ" "ㄘ" "ㄙ")
b=("" "ㄧ" "ㄨ" "ㄩ")
c=("" "ㄚ" "ㄛ" "ㄜ" "ㄝ" "ㄞ" "ㄟ" "ㄠ" "ㄡ" "ㄢ" "ㄣ" "ㄤ" "ㄥ" "ㄦ")
d=("" "˙" "ˊ" "ˇ" "ˋ")

frequency=0
for loop in  0 1  #注音第一列循環(a)
do
	for loop2 in 0 1 2 3 #注音第二列循環(b)
	do
		for loop3 in 0 1 2 3 4 5 6 7 8 9 10 11 12 13 #注音第三列循環(c)
		do
			for loop4 in 0 1 2 3 4 #音標循環(d)
			do
				echo "word_""$loop""_""$loop2""_""$loop3""_""$loop4" #輸出注音和音標號碼
				if [ $loop -eq 0 ] && [ $loop2 -eq 0 ] && [ $loop3 -eq 0 ] #如果注音均為空音就跳過
				then
					continue
				fi
				
				str=${a[loop]}${b[loop2]}${c[loop3]}${d[loop4]} #儲存注音和音標號碼
				#check=0 #記錄檔案是否為空音檔
				`ffmpeg -i "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ogg"`
				#`cmp --silent "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" word_1_3_13_4.ts` || check=1 #檢測檔案是否與空音檔相同
				#if [ $check -eq 0 ]; then echo `rm "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts"`; fi #是就刪除
				#f=`./ffprobe.exe -i "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" -show_entries format=duration -v quiet -of csv="p=0"` #檢查檔案大小是否正常
				#e=0.792000 #不正常的音檔大小
				#echo "$f"
				#if [ $f == $e ]; then echo `mv "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" /c/`; fi #如果音檔為此大小就刪除
			done
		done
	done
done

echo "complete"

#echo `trans --help`