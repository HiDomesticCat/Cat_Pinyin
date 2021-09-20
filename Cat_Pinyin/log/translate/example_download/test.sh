IFS=","
while read A B C D E F G H I; do
echo "example_""$E""_""$F""_""$G""_""$H" #輸出注音和音標號碼
	if [ -e "example_""$E""_""$F""_""$G""_""$H"".ts" ] #如果此檔案存在就跳過
	then
		continue
	fi
	echo "$E $F $G $H $I"
	echo `trans {zh-TW=zh-TW} -download-audio-as "example_""$E""_""$F""_""$G""_""$H"".ts" $I` #下載音檔
	while ! [ -e "example_""$E""_""$F""_""$G""_""$H"".ts" ] #檢測是否下載成功，沒有就等待30秒，在重新下載一次，直到檔案下載成功
	do 
		time1=$(date +"%s") #儲存起始時間值
		time2=$(date +"%s") #儲存現在時間值
		while [ `expr $time2 - $time1` -ne 30 ] #如果現在值減起始值不等於30秒，就更新現在時間值，直到現在時間值減起始時間值等於10分鐘
		do
			time2=$(date +"%s")
			echo "no network" `expr $time2 - $time1`
		done
		echo `trans {zh-TW=zh-TW} -download-audio-as "example_""$E""_""$F""_""$G""_""$H"".ts" $I` #下載音檔
	done
	
	Byte=`du -b "example_""$E""_""$F""_""$G""_""$H"".ts"` #查詢檔案大小
	Byte=${Byte:0:4} #只保留檔案大小數值
	echo "$Byte"" ""example_""$E""_""$F""_""$G""_""$H"".ts" #輸出檔案大小
	while [ $Byte -eq 1671 ] #如果檔案大小為此不正常大小，就等待1小時，在重新下載一次，直到檔案大小正常
	do 
		echo "no"" ""file"" ""example_""$E""_""$F""_""$G""_""$H"".ts"
		`rm "example_""$E""_""$F""_""$G""_""$H"".ts"`
		time1=$(date +"%s") #儲存起始時間值
		time2=$(date +"%s") #儲存現在時間值
		while [ `expr $time2 - $time1` -ne 1800 ] #如果現在值減起始值不等於1小時，就更新現在時間值，直到現在時間值減起始時間值等於1小時
		do
			time2=$(date +"%s")
			echo "unfile" `expr $time2 - $time1`
		done
		echo `trans {zh-TW=zh-TW} -download-audio-as "example_""$E""_""$F""_""$G""_""$H"".ts" $I` #下載音檔
		Byte=`du -b "example_""$E""_""$F""_""$G""_""$H"".ts"` #查詢檔案大小
		Byte=${Byte:0:4} #只保留檔案大小數值
	done
	echo "have"" ""file"" ""example_""$E""_""$F""_""$G""_""$H"".ts"
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
done < "pinyinfinal.csv" #讀取CSV檔

echo "complete"

#echo `trans --help`