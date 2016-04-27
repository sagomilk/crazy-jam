#OAuth


##应用场景
开放特性，对于某一个独立的系统而已
授权使用相关信息，在符合授权情况下使用信息

##步骤
###请求QQ OAuth登录页

1. 获取Request Token

		Request Token Url 带有特定参数的url		授权之前
		client_id=
		redirect_uri=回调地址

2. 用户使用QQ号登陆并授权, code 有效时间很短，只能使用一次
	
		code=xxxxxxxxxxxx, $_GET['code']

3. 获取Access Token返回登陆结果，服务端发起，AccessToken拥有较长的生命周期

		User Authorization URL 带有特定参数的url   授权之后
			client_id=
			client_secrect=
			code=xxxxxxx
	
		AccessToken


##令牌刷新RefreshToken
AccessToken过期2种处理方式

1. 重新认证
2. 动态请求刷新令牌 如： need_refresh_token=true

	应用场景： 定时任务

