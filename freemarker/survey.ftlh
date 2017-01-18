<html>
<head>
	<title>${title}</title>
	<style>
		ul {
			list-style-type: none;
		}
	</style>
	<!-- link rel="stylesheet" href="../html/styles.css" / -->
</head>
<body>
  <#-- Description of survey as a whole -->
  <h1>${description?no_esc}</h1>
  <ul>
  <#list questions as q>
    <section  data-limit="${q.selectionLimit!0}">
		<p>
			Question ${1+q?index} (${q.getHashCode()}): ${q.question}
		</p>
			<ul>
			<#if "textarea" == q.type>
				<textarea name="${q.getHashCode()}"></textarea>
			<#else>
				<#if q.options??>
					<#list q.options as opts>
						<li>
							<#if "checkbox" == q.type>
								<input name="${q.getHashCode()}" value="${opts.value}" type="checkbox" <#if opts.checked!false> checked="true"</#if> />
							<#elseif "radio" == q.type>
								<input name="${q.getHashCode()}" value="${opts.value}" type="radio" <#if opts.checked!false> checked="true"</#if> />
							</#if>
							${opts.answer}
						</li>
					</#list>
				</#if>
				<#if q.allowOther!false>
					Other: <input type="text" />
				</#if>
			</#if>
			</ul>
	</section>
  </#list>
	<!-- script src="../html/scripts.js"></script -->
</body>
</html>