/**
 * 
 */
package com.example.town_land_collect.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import com.example.town_land_collect.model.AttachmentEntity;
import com.example.town_land_collect.model.LocationInfo;

public class AttachmentUtil {
	/**
	 * 说明：TODO(保存成功后，关联附件信息)
	 * 
	 * @param locationInfo
	 * @return void
	 */
	@SuppressLint("SimpleDateFormat")
	public void saveAttachmentInfo(LocationInfo l) {
		if (l.getImageUri() != null) {
			String[] imageUrlStrings = l.getImageUri().split(",");
			for (String imageUri : imageUrlStrings) {
				AttachmentEntity a = new AttachmentEntity();
				a.setObjId(l.getId());
				a.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
				a.setStateCode(0);
				a.setImageUri(imageUri);
				a.save();
			}
		}
	}
}
