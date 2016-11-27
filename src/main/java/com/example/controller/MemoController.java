package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.beans.MemoForm;
import com.example.entities.Memo;
import com.example.services.MemoService;

@Controller
@RequestMapping("memo")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	/**
	 * 一覧表示
	 * @return
	 */
	@RequestMapping(method = {RequestMethod.GET})
	public ModelAndView index() {
		
		// 一覧を取得
		List<Memo> list = memoService.getAllList();
		
		// Modelを生成
		ModelAndView mv = new ModelAndView();
		
		// 取得したデータを画面へ割当
		mv.addObject("list", list);
		
		// 使用するビューを指定
		mv.setViewName("memo/index");
		
		// view
		return mv;
	}
	
	/**
	 * 新規画面
	 * @return
	 */
	@RequestMapping(value = {"new"}, method = {RequestMethod.GET})
	public ModelAndView _new(@ModelAttribute MemoForm form) {
		
		// Modelを生成
		ModelAndView mv = new ModelAndView();
				
		// 使用するビューを指定
		mv.setViewName("memo/new");
		
		// formを設定する
		mv.addObject("form", form);
		
		// view
		return mv;
	}
	
	/**
	 * 登録処理
	 * @return
	 */
	@RequestMapping(value = {"regist"}, method = {RequestMethod.POST})
	public String regist(@ModelAttribute MemoForm form) {
		
		// 追加処理
		memoService.regist(form);
		
		// view
		return "redirect:/memo";
	}
	
	/**
	 * 編集画面
	 * @param id
	 * @return
	 */
	@RequestMapping(value = {"edit/{id}"}, method = {RequestMethod.GET})
	public ModelAndView edit(@PathVariable("id") String id) {
		
		MemoForm form = memoService.getMemo(Integer.parseInt(id));
		
		// Modelを生成
		ModelAndView mv = new ModelAndView();
						
		// 使用するビューを指定
		mv.setViewName("memo/edit");
			
		// formを設定する
		mv.addObject("form", form);
				
		// view
		return mv;
	}
	
	/**
	 * 更新処理
	 * @return
	 */
	@RequestMapping(value = {"update"}, method = {RequestMethod.POST})
	public String update(@ModelAttribute MemoForm form) {
		
		// 更新処理
		memoService.update(form);
		
		// view
		return "redirect:/memo";
	}
	
	/**
	 * 削除実施
	 * @param id
	 * @return
	 */
	@RequestMapping(value = {"remove/{id}"}, method = {RequestMethod.GET})
	public String remove(@PathVariable("id") String id) {
		
		// 削除実行
		memoService.remove(Integer.parseInt(id));
		
		// 一覧へリダイレクトする
		return "redirect:/memo";
	}
	
}
