/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.xunjian_dict.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.MatrixToImageWriter;
import com.thinkgem.jeesite.modules.xunjian_dict.dao.XunjianDictDao;
import com.thinkgem.jeesite.modules.xunjian_dict.entity.XunjianDict;

/**
 * 管理巡检点Service
 * @author ktzhxm
 * @version 2016-02-17
 */
@Service
@Transactional(readOnly = true)
public class XunjianDictService extends CrudService<XunjianDictDao, XunjianDict> {

	public XunjianDict get(String id) {
		return super.get(id);
	}
	
	public List<XunjianDict> findList(XunjianDict xunjianDict) {
		return super.findList(xunjianDict);
	}
	
	public Page<XunjianDict> findPage(Page<XunjianDict> page, XunjianDict xunjianDict) {
		return super.findPage(page, xunjianDict);
	}
	
	@Transactional(readOnly = false)
	public void save(XunjianDict xunjianDict) {
		super.save(xunjianDict);
		
		String str=XunjianDictService.class.getResource("/").getFile();
		String path=new File(str).getParentFile().getParentFile().getPath();
		//生成二维码文件
		try {
			MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			Map hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = multiFormatWriter.encode(xunjianDict.getId(), BarcodeFormat.QR_CODE, 400, 400, hints);
			File file1 = new File(path+"\\userfiles", xunjianDict.getId() + ".jpg");
			MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(XunjianDict xunjianDict) {
		super.delete(xunjianDict);
	}

	public List<String> findLeixingList() {
		return dao.findLeixingList(new XunjianDict());
	}

	public List<XunjianDict> findListByLeixing(String leixingStr) {
		return dao.findListByLeixing(leixingStr);
	}
	
}