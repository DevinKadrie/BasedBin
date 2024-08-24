@if "%BASEDBIN_DEBUG%" == "" @echo off

FOR %%A IN ("%~dp0.") DO SET root=%%~dpA
CD %root%

docker compose -f compose.dev.yaml up --watch