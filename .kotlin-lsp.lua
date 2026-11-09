-- .kotlin-lsp.lua
return {
	jdk_for_symbol_resolution = "/usr/lib/jvm/java-17-openjdk",
	inlay_hints = { enabled = false },
	jvm_args = { "-Xmx8g" },
	cmd_env = {
		IJ_JAVA_OPTIONS = vim.NIL,
	},
}
