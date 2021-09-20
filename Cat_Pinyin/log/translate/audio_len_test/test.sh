#char a[21][5] = {"ㄅ","ㄆ","ㄇ","ㄈ","ㄉ","ㄊ","ㄋ","ㄌ","ㄍ","ㄎ","ㄏ","ㄐ","ㄑ","ㄒ","ㄓ","ㄔ","ㄕ","ㄖ","ㄗ","ㄘ","ㄙ"};
#char b[3][5] = {"一","ㄨ","ㄩ"};
#char c[13][5] = {"ㄚ","ㄛ","ㄜ","ㄝ","ㄞ","ㄟ","ㄠ","ㄡ","ㄢ","ㄣ","ㄤ","ㄥ","ㄦ"};

a=("" "ㄅ" "ㄆ" "ㄇ" "ㄈ" "ㄉ" "ㄊ" "ㄋ" "ㄌ" "ㄍ" "ㄎ" "ㄏ" "ㄐ" "ㄑ" "ㄒ" "ㄓ" "ㄔ" "ㄕ" "ㄖ" "ㄗ" "ㄘ" "ㄙ")
b=("" "ㄧ" "ㄨ" "ㄩ")
c=("" "ㄚ" "ㄛ" "ㄜ" "ㄝ" "ㄞ" "ㄟ" "ㄠ" "ㄡ" "ㄢ" "ㄣ" "ㄤ" "ㄥ" "ㄦ")
d=("" "˙" "ˊ" "ˇ" "ˋ")

frequency=0
for loop in  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 #注音第一列循環(a)
do
	for loop2 in 0 1 2 3 #注音第二列循環(b)
	do
		for loop3 in 0 1 2 3 4 5 6 7 8 9 10 11 12 13 #注音第三列循環(c)
		do
			for loop4 in 0 1 2 3 4 #音標循環(d)
			do
				echo "word_""$loop""_""$loop2""_""$loop3""_""$loop4" #輸出注音和音標號碼
				if [ -e "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" ] #如果此檔案存在就跳過
				then
					continue
				fi
				if [ $loop -eq 0 ] && [ $loop2 -eq 0 ] && [ $loop3 -eq 0 ] #如果注音均為空音就跳過
				then
					continue
				fi
				
				#echo "trans {zh-TW=zh-TW} -download-audio-as "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" ${a[loop]}${b[loop2]}${c[loop3]}${d[loop4]}"
				str=${a[loop]}${b[loop2]}${c[loop3]}${d[loop4]} #儲存注音和音標號碼
				echo `trans {zh-TW=zh-TW} -download-audio-as "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" ${str}` #下載音檔
				while ! [ -e "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" ] #檢測是否下載成功，沒有就等待30秒，在重新下載一次，直到檔案下載成功
				do 
					time1=$(date +"%s") #儲存起始時間值
					time2=$(date +"%s") #儲存現在時間值
					while [ `expr $time2 - $time1` -ne 30 ] #如果現在值減起始值不等於30秒，就更新現在時間值，直到現在時間值減起始時間值等於10分鐘
					do
						time2=$(date +"%s")
						echo "no network" `expr $time2 - $time1`
					done
					echo `trans {zh-TW=zh-TW} -download-audio-as "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" ${str}`
				done
				#f=`./ffprobe.exe -i "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" -show_entries format=duration -v quiet -of csv="p=0"` #檢查檔案大小是否正常
				#e=0.672000 #不正常的音檔大小
				#if [ $f == $e ]; then echo `rm "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts"`; fi #如果音檔為此大小就刪除
				Byte=`du -b "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts"` #查詢檔案大小
				Byte=${Byte:0:4} #只保留檔案大小數值
				echo "$Byte"" ""word""_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" #輸出檔案大小
				while [ $Byte -eq 1671 ] #如果檔案大小為此不正常大小，就等待1小時，在重新下載一次，直到檔案大小正常
				do 
					echo "no"" ""file"" ""word""_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts"
					`rm "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts"`
					time1=$(date +"%s") #儲存起始時間值
					time2=$(date +"%s") #儲存現在時間值
					while [ `expr $time2 - $time1` -ne 1800 ] #如果現在值減起始值不等於1小時，就更新現在時間值，直到現在時間值減起始時間值等於1小時
					do
						time2=$(date +"%s")
						echo "unfile" `expr $time2 - $time1`
					done
					echo `trans {zh-TW=zh-TW} -download-audio-as "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts" ${str}`
					Byte=`du -b "word_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts"` #查詢檔案大小
					Byte=${Byte:0:4} #只保留檔案大小數值
				done
				echo "have"" ""file"" ""word""_""$loop""_""$loop2""_""$loop3""_""$loop4"".ts"
				frequency=`expr $frequency + 1`
				echo $frequency
				if [ $frequency -eq 5 ] #如果已經執行5次運算，就休息10秒
				then
					frequency=0
					time1=$(date +"%s") #儲存起始時間值
					time2=$(date +"%s") #儲存現在時間值
					while [ `expr $time2 - $time1` -ne 10 ] #如果現在值減起始值不等於10分鐘，就更新現在時間值，直到現在時間值減起始時間值等於10分鐘
					do
						time2=$(date +"%s")
						echo "reload" `expr $time2 - $time1`
					done
				fi
			done
		done
	done
done

echo "complete"

#echo `trans --help`