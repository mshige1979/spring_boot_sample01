package com.example.services;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.MemoForm;
import com.example.entities.Memo;
import com.example.repositories.MemoRepository;

@Service
@Transactional
public class MemoService {
	@Autowired
	MemoRepository repository;
	
	/**
	 * 全件取得
	 * @return
	 */
	public List<Memo> getAllList() {
		return repository.findAll();
	}
	
	/**
	 * 1件取得
	 * @return
	 */
	public MemoForm getMemo(Integer id) {
		Memo newMemo = repository.findById(id);
		
		MemoForm form = new MemoForm();
		form.setId(newMemo.getId());
		form.setName(newMemo.getName());
		form.setMemo(newMemo.getMemo());
		form.setCreateAt(newMemo.getCreateAt());
		form.setUpdateAt(newMemo.getUpdateAt());
		
		return form;
	}
	
	/**
	 * 追加
	 * @param memo
	 * @return
	 */
	public Memo regist(MemoForm form) {
		
		// 新しく作成して値を設定
		Memo memo = new Memo();
		memo.setName(form.getName());
		memo.setMemo(form.getMemo());
		memo.setCreateAt(new Timestamp(System.currentTimeMillis()));
		memo.setUpdateAt(new Timestamp(System.currentTimeMillis()));
		
		// 登録
		return repository.save(memo);
	}
	
	/**
	 * 追加
	 * @param memo
	 * @return
	 */
	public Memo update(MemoForm form) {
		
		// 新しく作成して値を設定
		Memo memo = new Memo();
		memo.setId(form.getId());
		memo.setName(form.getName());
		memo.setMemo(form.getMemo());
		memo.setCreateAt(form.getCreateAt());
		memo.setUpdateAt(new Timestamp(System.currentTimeMillis()));
		
		// 更新
		return repository.save(memo);
	}
	
	/**
	 * 削除
	 * @param id
	 */
	public void remove(Integer id) {
		Memo memo = new Memo();
		memo.setId(id);
		repository.delete(memo);
	}
}
